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
package net.raphimc.viacosmicreach;

import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;

public enum ServerboundCosmicReachPackets implements ServerboundPacketType {

    TRANSACTION(2, "finalforeach.cosmicreach.networking.netty.packets.meta.TransactionPacket"),
    LOGIN(3, "finalforeach.cosmicreach.networking.netty.packets.meta.LoginPacket"),
    MESSAGE(6, "finalforeach.cosmicreach.networking.netty.packets.MessagePacket"),
    PLAYER_POSITION(7, "finalforeach.cosmicreach.networking.netty.packets.PlayerPositionPacket"),
    PLACE_BLOCK(10, "finalforeach.cosmicreach.networking.netty.packets.blocks.PlaceBlockPacket"),
    BREAK_BLOCK(11, "finalforeach.cosmicreach.networking.netty.packets.blocks.BreakBlockPacket"),
    INTERACT_BLOCK(12, "finalforeach.cosmicreach.networking.netty.packets.blocks.InteractBlockPacket"),
    SLOT_INTERACT(16, "finalforeach.cosmicreach.networking.netty.packets.SlotInteractPacket"),
    CONTAINER_SYNC(17, "finalforeach.cosmicreach.networking.netty.packets.ContainerSyncPacket"),
    BLOCK_ENTITY_CONTAINER_SYNC(18, "finalforeach.cosmicreach.networking.netty.packets.blocks.BlockEntityContainerSyncPacket");

    private static final ServerboundCosmicReachPackets[] REGISTRY = new ServerboundCosmicReachPackets[128];
    private static final Object2IntMap<String> CLASS_TO_ID = new Object2IntOpenHashMap<>();

    static {
        for (ServerboundCosmicReachPackets packet : values()) {
            REGISTRY[packet.id] = packet;
            CLASS_TO_ID.put(packet.className, packet.id);
        }
    }

    public static ServerboundCosmicReachPackets getPacket(final int id) {
        if (id < 0 || id >= REGISTRY.length) return null;

        return REGISTRY[id];
    }

    public static ServerboundCosmicReachPackets getPacket(final String className) {
        return CLASS_TO_ID.containsKey(className) ? REGISTRY[CLASS_TO_ID.getInt(className)] : null;
    }

    ServerboundCosmicReachPackets(final int id, final String className) {
        this.id = id;
        this.className = className;
    }

    private final int id;
    private final String className;

    @Override
    public int getId() {
        return this.id;
    }

    public String getClassName() {
        return this.className;
    }

    @Override
    public String getName() {
        return name();
    }

}
