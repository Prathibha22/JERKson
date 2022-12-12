package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
      // System.out.println(originalFileText);
        List<Item> lstItems=new ArrayList<>();
        ItemParser objItemParser=new ItemParser();
       lstItems=objItemParser.parseItemList(this.originalFileText);
       for(Item item:lstItems) System.out.println(item);


    }


    @Override
    public String toString() {
        return null;
    }
}

