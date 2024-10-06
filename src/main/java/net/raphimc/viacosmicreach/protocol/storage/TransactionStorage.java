/*
 * This file is part of ViaCosmicReach - https://github.com/RaphiMC/ViaCosmicReach
 * Copyright (C) 2024-2024 RK_01/RaphiMC and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.raphimc.viacosmicreach.protocol.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;

import java.util.concurrent.atomic.AtomicInteger;

public class TransactionStorage implements StorableObject {

    private final AtomicInteger transactionId = new AtomicInteger(1);
    private final Int2ObjectMap<Long> pendingTransactions = new Int2ObjectOpenHashMap<>();

    public int createJavaTransactionId(final Long cosmicReachId) {
        final int javaId = this.transactionId.getAndIncrement();
        this.pendingTransactions.put(javaId, cosmicReachId);
        return javaId;
    }

    public Long getAndRemoveCosmicReachTransactionId(final int javaId) {
        if (!this.pendingTransactions.containsKey(javaId)) {
            throw new IllegalArgumentException("No transaction found with id " + javaId);
        } else {
            return this.pendingTransactions.remove(javaId);
        }
    }

}
