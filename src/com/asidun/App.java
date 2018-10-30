package com.asidun;

import gherkin.lexer.No;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class App {

    public static void main(String[] args) {

         Map<String, Node> wordMap = new LinkedHashMap<>();

        try(Stream<String> line = Files.lines(Paths.get("text.txt"))){
            //line.forEach(System.out::println);
            line.flatMap(row -> Arrays.stream(row.split(" ")))
                    .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                    .filter(word -> word.length() > 0)
                    .forEach(word -> {
                        Node node;
                        Optional optNode = Optional.ofNullable(wordMap.get(word));
                        if (optNode.isPresent()){
                            node = (Node) optNode.get();
                            node.incrementCount();
                        } else {
                            wordMap.put(word, new Node(word));
                        }
                    });
            System.out.println(wordMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinkedHashMap<String, Node> sorted = wordMap.entrySet().stream().sorted(comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>(sorted.values());

        System.out.println(nodePriorityQueue);

    }
}
