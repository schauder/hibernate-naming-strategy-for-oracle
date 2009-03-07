package de.schauderhaft.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

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

/**
 * An Entity for demonstrating the features of the Oracle Naming Strategy
 * 
 * @author Jens.Schauder
 * 
 */
@Entity
public class SomeLongNamedEntityForDemonstrationPurposes {
    @Id
    private Long id;

    private String donauDampfSchifffahrtsGesellschaft;

    HibernateDemonstrationEmbeddable somethingEmbedded;
    HibernateDemonstrationEmbeddable somethingElseEmbedded;

    @Entity
    public static class InnerClass {
        @Id
        private Long id;

        String anAttribute;
    }
}
