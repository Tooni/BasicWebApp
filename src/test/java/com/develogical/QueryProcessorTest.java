package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutFaulkner() throws Exception {
        assertThat(queryProcessor.process("faulkner"), containsString("Nobel Prize"));
    }

    @Test
    public void determinesLargestOfTwoNumbers() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest:1222,233 "), containsString("1222"));
    }

    @Test
    public void determinesLargestOfThreeNumbers() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest:1222,233, 333 "), containsString("1222"));
    }

    @Test
    public void knowsWhoPlayedBondInDrNo() throws Exception {
        assertThat(queryProcessor.process("who played james bond in dr no?"), containsString("Sean Connery"));
    }
}
