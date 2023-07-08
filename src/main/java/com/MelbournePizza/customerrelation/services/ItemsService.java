package com.MelbournePizza.customerrelation.services;

import com.MelbournePizza.customerrelation.payloads.ItemsDto;

import java.util.List;

public interface ItemsService {

    // crud operation
    // create new items for menu
    ItemsDto createNewItem (ItemsDto itemsDto);

    // update new items for menu
    ItemsDto updateItemById(ItemsDto itemsDto, Integer itemId);

    // delete items by id from menu
    void deleteItemById(Integer itemId);

    // get all items from list

    List<ItemsDto> getAllItems();

    // get items by id

    ItemsDto getItemsById(Integer itemId);

}
