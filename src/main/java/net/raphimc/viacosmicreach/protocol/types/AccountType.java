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
package net.raphimc.viacosmicreach.protocol.types;

import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.libs.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import net.raphimc.viacosmicreach.protocol.model.Account;
import net.raphimc.viacosmicreach.protocol.model.OfflineAccount;

public class AccountType extends Type<Account> {

    public AccountType() {
        super(Account.class);
    }

    @Override
    public Account read(ByteBuf buffer) {
        final String type = CosmicReachTypes.STRING.read(buffer);
        final JsonObject obj = CosmicReachTypes.JSON_OBJECT.read(buffer);

        final String username = obj.get("username").getAsString();
        final String uniqueId = obj.get("uniqueId").getAsString();
        return switch (type) {
            case OfflineAccount.TYPE -> new OfflineAccount(username, uniqueId);
            default -> throw new IllegalArgumentException("Unexpected account type: " + type);
        };
    }

    @Override
    public void write(ByteBuf buffer, Account value) {
        final JsonObject obj = new JsonObject();
        obj.addProperty("username", value.username());
        obj.addProperty("uniqueId", value.uniqueId());

        CosmicReachTypes.STRING.write(buffer, value.type());
        CosmicReachTypes.JSON_OBJECT.write(buffer, obj);
    }

}
