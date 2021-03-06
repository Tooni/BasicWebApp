package com.develogical;

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
        } else if (query.toLowerCase().contains("theresa may first")) {
            return "2016";
        } else if (query.toLowerCase().contains("eiffel tower")) {
            return "Paris";
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
        } else if (query.toLowerCase().contains("both a square and a cube")) {
            String unsplit = query.toLowerCase();
            String colonSplit[] = unsplit.split("cube:");
            String numList[] = colonSplit[1].split(",");
            String result = "";

            for (String s : numList) {
                int thisNum = Integer.parseInt(s.trim());
                int cube_root = (int) Math.round(Math.pow(thisNum, 1.0/3.0));
                int square_root = (int) Math.round(Math.pow(thisNum, 1.0/2.0));

                if (cube_root * cube_root * cube_root == thisNum &&
                square_root * square_root == thisNum) {
                    if (result.length() == 0) {
                        result += thisNum;
                    } else {
                        result += ", " + thisNum;
                    }
                }
            }
            return result;
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
        } else if (query.toLowerCase().contains("minus")) {
            if (query.contains(":")) {
                query = query.split(":")[1];
            }
            String numberString = query.replaceAll("[^-?0-9]+", " ");
            List<String> numbers = Arrays.asList(numberString.trim().split(" "));
            int sub = 0;
            for (String num : numbers) {
                sub -= Integer.parseInt(num.trim());
            }
            return Integer.toString(sub);
        } else if (query.toLowerCase().contains("fibonacci")) {
            if (query.contains(":")) {
                query = query.split(":")[1];
            }
            String numberString = query.replaceAll("[^-?0-9]+", " ");
            List<String> numbers = Arrays.asList(numberString.trim().split(" "));
            int n = Integer.parseInt(numbers.get(0));
            int a = 0;
            int b = 1;
            for (int i = 0; i < n; i++) {
                int temp = a;
                a = b;
                b = temp + b;
            }

            return Integer.toString(a);
        } else if (query.toLowerCase().contains("power")) {
            if (query.contains(":")) {
                query = query.split(":")[1];
            }
            String numberString = query.replaceAll("[^-?0-9]+", " ");
            List<String> numbers = Arrays.asList(numberString.trim().split(" "));
            int base = Integer.parseInt(numbers.get(0));
            int power = Integer.parseInt(numbers.get(1));
            int ans = 1;
            for (int i = 0; i < power; i++) {
                ans *= base;
            }
            return Integer.toString(ans);
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
