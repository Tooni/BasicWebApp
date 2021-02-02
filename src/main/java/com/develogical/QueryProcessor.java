package com.develogical;

import javax.management.Query;
import java.util.Arrays;
import java.util.List;

public class QueryProcessor {
    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("faulkner")) {
            return "William Cuthbert Faulkner (25 September 1897 – 6 July 1962) was an " +
                    "American writer and  Nobel Prize laureate from Oxford, Mississippi. " +
                    "Faulkner wrote novels, short stories, screenplays, poetry, essays, " +
                    "and a play. He is primarily known for his novels and short stories " +
                    "set in the fictional Yoknapatawpha County, based on Lafayette " +
                    "County, Mississippi, where he spent most of his life.";
        } else if (query.toLowerCase().contains("steinbeck")) {
            return "John Ernst Steinbeck Jr. (27 February 1902 – 20 December 1968) was " +
                    "an American author and the 1962 Nobel Prize in Literature winner " +
                    "\"for his realistic and imaginative writings, combining as they " +
                    "do sympathetic humour and keen social perception.\" He has been " +
                    "called \"a giant of American letters,\" and many of his works " +
                    "are considered classics of Western literature.";
        } else if (query.toLowerCase().contains("james bond") && query.toLowerCase().contains("dr no")) {
            return "Sean Connery";
        } else if (query.toLowerCase().contains("your name")) {
            return "NSBTJD";
        } else if (query.toLowerCase().contains("which of the following numbers is the largest")) {
            String unsplit = query.toLowerCase();
            String colonSplit[] = unsplit.split("largest:");
            String numList[] = colonSplit[1].split(",");
            int max = 0;
            for (String s : numList) {
                int thisNum = Integer.parseInt(s.trim());
                if (max < thisNum) {
                    max = thisNum;
                }
            }
            return Integer.toString(max);
        } else if (query.toLowerCase().contains("numbers are primes")) {
            String unsplit = query.toLowerCase();
            String colonSplit[] = unsplit.split("primes:");
            String numList[] = colonSplit[1].split(",");
            StringBuilder sb = new StringBuilder();
            for (String num : numList) {
                int n = Integer.parseInt(num.trim());
                if (QueryProcessor.isPrime(n)) {
                    sb.append(n);
                    sb.append(",");
                }
            }
            if (sb.length() > 0) { // cut last comma
                sb.setLength(sb.length() - 1);
            }
            return sb.toString();
        } else if (query.toLowerCase().contains("plus")) {
            if (query.contains(":")) {
                query = query.split(":")[1];
            }
            String numberString = query.replaceAll("[^-?0-9]+", " ");
            List<String> numbers = Arrays.asList(numberString.trim().split(" "));
            int sum = 0;
            for (String num : numbers) {
                sum += Integer.parseInt(num.trim());
            }
            return Integer.toString(sum);
        } else if (query.toLowerCase().contains("multiplied")) {
            if (query.contains(":")) {
                query = query.split(":")[1];
            }
            String numberString = query.replaceAll("[^-?0-9]+", " ");
            List<String> numbers = Arrays.asList(numberString.trim().split(" "));
            int total = 1;
            for (String num : numbers) {
                total *= Integer.parseInt(num.trim());
            }
            return Integer.toString(total);
        }
        return "";
    }

    public static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
