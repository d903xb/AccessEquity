package com.accesseq.trade.properties;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PropertiesParserTest {

    @Test
    public void parsePropertiesFileTest() throws IOException {

        System.setProperty("propertyfile.location", "cfg\\local\\TradeLoader.json");
}
}