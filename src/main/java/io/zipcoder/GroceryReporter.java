package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
        List<Item> lstItems=new ArrayList<>();
        ItemParser objItemParser=new ItemParser();
       lstItems=objItemParser.parseItemList(this.originalFileText);
        Map<String, List<Item>> map = groupBy(lstItems, Item::getName);
        map.forEach((k, v) -> System.out.println(k + " => " + v));


    }
    public static <E, K> Map<K, List<E>> groupBy(List<E> list, Function<E, K> keyFunction) {
        return Optional.ofNullable(list)
                .orElseGet(ArrayList::new)
                .stream()
                .collect(Collectors.groupingBy(keyFunction));
    }


    @Override
    public String toString() {
        return null;
    }
}

