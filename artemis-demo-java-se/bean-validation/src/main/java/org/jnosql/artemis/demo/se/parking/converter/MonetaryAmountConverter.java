/*
 * Copyright (c) 2019 Otávio Santana and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 *
 * Contributors:
 *
 * Otavio Santana
 */
package org.jnosql.artemis.demo.se.parking.converter;

import org.bson.types.ObjectId;
import org.javamoney.moneta.Money;
import org.jnosql.artemis.AttributeConverter;

import javax.money.MonetaryAmount;

public class MonetaryAmountConverter implements AttributeConverter<String, MonetaryAmount> {

    @Override
    public MonetaryAmount convertToDatabaseColumn(String attribute) {
        if(attribute == null) {
            return null;
        }
        return Money.parse(attribute);
    }

    @Override
    public String convertToEntityAttribute(MonetaryAmount dbData) {
        if(dbData == null) {
            return null;
        }
        return dbData.toString();
    }
}