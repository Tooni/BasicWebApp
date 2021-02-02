package com.develogical;

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
        } else if (query.toLowerCase().contains("your name")) {
            return "NSBTJD";
        } else if (query.toLowerCase().contains("which of the following numbers is the largest")) {
            //System.out.println(query);
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
        }
        return "";
    }
}
