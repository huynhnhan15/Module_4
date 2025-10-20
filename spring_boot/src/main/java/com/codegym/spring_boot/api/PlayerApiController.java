package com.codegym.spring_boot.api;


import com.codegym.spring_boot.dto.PlayerDto;
import com.codegym.spring_boot.entity.Player;
import com.codegym.spring_boot.service.IPlayerService;
import com.codegym.spring_boot.validation.PlayerValidate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/api/players")
@CrossOrigin("*")
public class PlayerApiController {

    @Autowired
    private IPlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.findAll();
        return ResponseEntity.ok(players);
    }

    @PostMapping
    public ResponseEntity<?> createPlayer(@RequestBody PlayerDto playerDto, BindingResult bindingResult) {
        new PlayerValidate().validate(playerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(err ->
                    errors.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        playerService.add(player);

        return ResponseEntity.created(URI.create("/api/players/" + player.getId())).body(player);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable int id) {
        Player player = playerService.findById(id);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Player>> searchByName(@RequestParam("q") String name) {
        List<Player> results = playerService.searchByName(name);
        return ResponseEntity.ok(results);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable int id, @RequestBody PlayerDto playerDto) {
        Player existing = playerService.findById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(playerDto, existing, "id");
        playerService.add(existing);
        return ResponseEntity.ok(existing);
    }

}