/*
 * Copyright 2009 The Pinniped Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");  you may
 * not use this file except in compliance with the License. You  may obtain
 * a copy of the License at
 *
 *               http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless  required by  applicable law or  agreed to in  writing,  software
 * distributed  under  the  License  is  distributed  on an  "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See  the License for the  specific language  governing  permissions  and
 * limitations under the License. 
 */

package de.schauderhaft.hibernate;

import static de.schauderhaft.hibernate.OracleNamingStrategy.addUnderscores;
import static org.junit.Assert.assertEquals;

import de.schauderhaft.hibernate.SomeLongNamedEntityForDemonstrationPurposes.InnerClass;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jens.Schauder
 * 
 */
public class OracleNamingStrategyTest {

    /**
     * A little main class for actually creating some scripts with stupid long
     * names
     * 
     * @param args
     */
    public static void main(String[] args) {

        AnnotationConfiguration config = new AnnotationConfiguration();
        config
                .addAnnotatedClass(SomeLongNamedEntityForDemonstrationPurposes.class);
        config.addAnnotatedClass(InnerClass.class);
        config.addAnnotatedClass(HibernateDemonstrationEmbeddable.class);
        config.setNamingStrategy(new OracleNamingStrategy());
        config.setProperty("hibernate.dialect",
                "org.hibernate.dialect.Oracle9Dialect");

        new SchemaExport(config).create(true, false);
    }

    @Test
    public void testInsertUnderscoreBetweenWords1() {
        Assert.assertEquals("alpha_beta", addUnderscores("alphaBeta"));
    }

    @Test
    public void testInsertUnderscoreBetweenWords2() {
        Assert.assertEquals("alpha_beta", addUnderscores("AlphaBeta"));
    }

    @Test
    public void testNotInsertUnderscore() {
        Assert.assertEquals("alfred", addUnderscores("alfred"));
    }

    @Test
    public void testNotInsertUnderscoreBetweenTwoCapitals() {
        Assert.assertEquals("some_id", addUnderscores("someID"));
    }

    @Test
    public void testInsertUnderscoreMultipleCapitals() {
        assertEquals("abc_something", addUnderscores("ABCsomething"));
    }
}
