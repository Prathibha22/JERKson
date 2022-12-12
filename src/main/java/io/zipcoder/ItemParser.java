package io.zipcoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;
import io.zipcoder.utils.match.MatchGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse)
    {
        List<Item> items=new ArrayList<>();
        String[] input=valueToParse.split("##");
        for(String str:input) {
            try {
                if(parseSingleItem(str)!=null)
                items.add(parseSingleItem(str));
            } catch (ItemParseException e) {
                throw new RuntimeException(e);
            }
        }
        return items;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
       // String output=singleItem.replaceAll("##","");
        try {
            Pattern pattern = Pattern.compile("[!;:@^*%#]");
            Matcher matcher = pattern.matcher(singleItem);
            while (matcher.find()) {
                singleItem = matcher.replaceAll(" ");
            }
           // System.out.println(singleItem);
            String[] pairs = singleItem.split(" +");

            if (pairs.length > 7) {
             //   System.out.println(pairs.length);

                Item item = new Item(pairs[1].toLowerCase(), Double.valueOf(pairs[3]),
                        pairs[5].toLowerCase(), pairs[7]);
                return item;
            }
        }
        catch (Exception ex){
            throw new ItemParseException();}
       return null;

//        Pattern pattern1 = Pattern.compile("\\s+");
//        Matcher matcher2 = pattern1.matcher(output);
//        MatchGroup matchGroup = new MatchGroup(matcher2);

       // System.out.println(matchGroup.toString());
//        System.out.println(output);
//       Map<String, String> myMap = new HashMap<String, String>();
//        String[] pairs = output.split(";");
//        for (int i=0;i<pairs.length;i++) {
//            String pair = pairs[i];
//            System.out.println(pair.toLowerCase());
//          // String[] keyValue = pair.split(":");
//            //for(String str: keyValue) System.out.println(str);
//          // myMap.put(keyValue[0].toLowerCase(), keyValue[1].toLowerCase());
//        }

//       for (Map.Entry<String,String> entry : myMap.entrySet())
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());

    }
}
