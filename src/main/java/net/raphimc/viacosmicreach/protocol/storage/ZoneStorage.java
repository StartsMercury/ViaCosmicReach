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
import com.viaversion.viaversion.libs.gson.JsonObject;

public class ZoneStorage implements StorableObject {

    private final String id;
    private final float spawnX;
    private final float spawnY;
    private final float spawnZ;

    public ZoneStorage(final JsonObject zoneData) {
        this.id = zoneData.get("zoneId").getAsString();
        final JsonObject spawn = zoneData.getAsJsonObject("spawnPoint");
        this.spawnX = spawn.get("x").getAsFloat();
        this.spawnY = spawn.get("y").getAsFloat();
        this.spawnZ = spawn.get("z").getAsFloat();
    }

    public String getId() {
        return this.id;
    }

    public float getSpawnX() {
        return this.spawnX;
    }

    public float getSpawnY() {
        return this.spawnY;
    }

    public float getSpawnZ() {
        return this.spawnZ;
    }

}
