package com.MelbournePizza.customerrelation.services.serviceImpl;

import com.MelbournePizza.customerrelation.entities.Items;
import com.MelbournePizza.customerrelation.exceptions.ResourceNotFoundException;
import com.MelbournePizza.customerrelation.payloads.ItemsDto;
import com.MelbournePizza.customerrelation.repositories.ItemsRepo;
import com.MelbournePizza.customerrelation.services.ItemsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemsService {
    
    @Autowired
    private ItemsRepo itemsRepo;
    
    @Autowired
    private ModelMapper modelMapper;
    
    
    
    @Override
    public ItemsDto createNewItem(ItemsDto itemsDto) {
        Items items = this.modelMapper.map(itemsDto, Items.class);
        Items savedItems = this.itemsRepo.save(items);
        ItemsDto savedItemsDto = this.modelMapper.map(savedItems, ItemsDto.class);
        return savedItemsDto;
    }

    @Override
    public ItemsDto updateItemById(ItemsDto itemsDto, Integer itemId) {
        Items items = this.itemsRepo.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item", "Item id", itemId));
        items.setNameOfItem(itemsDto.getNameOfItem());
        items.setPrice(itemsDto.getPrice());
        Items updatedItems = this.itemsRepo.save(items);
        ItemsDto updatedItemsDto = this.modelMapper.map(updatedItems, ItemsDto.class);
        return updatedItemsDto;
    }

    @Override
    public void deleteItemById(Integer itemId) {
        Items items = this.itemsRepo.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item", "Item Id", itemId));
        this.itemsRepo.delete(items);
    }

    @Override
    public List<ItemsDto> getAllItems() {
        List<Items> allItems = this.itemsRepo.findAll();
        List<ItemsDto> allItemsDtos = allItems.stream().map(items -> this.modelMapper.map(items, ItemsDto.class)).collect(Collectors.toList());
        return allItemsDtos;
    }

    @Override
    public ItemsDto getItemsById(Integer itemId) {
        Items items = this.itemsRepo.findById(itemId).orElseThrow(() -> new ResourceNotFoundException("Item", "Item id", itemId));
        ItemsDto itemsDto = this.modelMapper.map(items, ItemsDto.class);
        return itemsDto;
    }
}
