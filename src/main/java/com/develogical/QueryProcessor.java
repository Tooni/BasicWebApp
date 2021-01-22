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
                    "Faulkner wrote novels, short stories, screenplays, poetry, essays, and a play. " +
                    "He is primarily known for his novels and short stories set in the fictional Yoknapatawpha County, " +
                    "based on Lafayette County, Mississippi, where he spent most of his life.";
        }
        return "";
    }
}
