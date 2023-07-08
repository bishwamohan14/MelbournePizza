package com.MelbournePizza.customerrelation.controllers;


import com.MelbournePizza.customerrelation.payloads.ApiResponse;
import com.MelbournePizza.customerrelation.payloads.ItemsDto;
import com.MelbournePizza.customerrelation.services.ItemsService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    //crud - create ,read(get by id,get all),update,delete

    @Autowired
    private ItemsService itemsService;

    //create  -- postMapping

    @PostMapping("/add")
    public ResponseEntity<ItemsDto> createMenu(@Valid @RequestBody ItemsDto itemsDto){
        ItemsDto createItem = this.itemsService.createNewItem(itemsDto);
        return new ResponseEntity<>(createItem, HttpStatus.CREATED);
    }

    //update --- putMapping


    @PutMapping("/{itemId}")
    public ResponseEntity<ItemsDto> updateMenu(@Valid @RequestBody ItemsDto itemsDto, @PathVariable Integer itemId){
        ItemsDto updatedMenu = this.itemsService.updateItemById(itemsDto, itemId);
        return ResponseEntity.ok(updatedMenu);
    }

    // delete mapping ---

    @DeleteMapping("/{itemId}")
    public ResponseEntity<ApiResponse> deleteMenu(@PathVariable Integer itemId){
        this.itemsService.deleteItemById(itemId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Item successfully",true),HttpStatus.OK);
    }

    // get all items -- use Get mapping

    @GetMapping("/")
    public ResponseEntity<List<ItemsDto>> getAllItemsFromMenu(){
        return ResponseEntity.ok(this.itemsService.getAllItems());
    }

    // get single item from menu using item id

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemsDto>  getAllCustomers(@PathVariable Integer itemId){
        return ResponseEntity.ok(this.itemsService.getItemsById(itemId));
    }


}
