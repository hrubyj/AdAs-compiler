package cz.zcu.kiv.vo;

import java.util.ArrayList;
import java.util.List;

public class FunctionScope extends Expression{

    private final List<BlockItem> blockItems = new ArrayList<>();

    public List<BlockItem> getBlockItems() {
        return blockItems;
    }

    public void addBlockItem(BlockItem blockItem) {
        blockItems.add(blockItem);
    }
}
