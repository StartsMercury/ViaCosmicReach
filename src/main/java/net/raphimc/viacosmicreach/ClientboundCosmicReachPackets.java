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

import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;

public enum ClientboundCosmicReachPackets implements ClientboundPacketType {

    PROTOCOL_SYNC(1, "finalforeach.cosmicreach.networking.netty.packets.meta.ProtocolSyncPacket"),
    TRANSACTION(2, "finalforeach.cosmicreach.networking.netty.packets.meta.TransactionPacket"),
    DISCONNECT(4, "finalforeach.cosmicreach.networking.netty.packets.meta.DisconnectPacket"),
    PLAYER(5, "finalforeach.cosmicreach.networking.netty.packets.PlayerPacket"),
    MESSAGE(6, "finalforeach.cosmicreach.networking.netty.packets.MessagePacket"),
    PLAYER_POSITION(7, "finalforeach.cosmicreach.networking.netty.packets.PlayerPositionPacket"),
    ZONE(8, "finalforeach.cosmicreach.networking.netty.packets.ZonePacket"),
    CHUNK_COLUMN(9, "finalforeach.cosmicreach.networking.netty.packets.ChunkColumnPacket"),
    BLOCK_REPLACE(13, "finalforeach.cosmicreach.networking.netty.packets.blocks.BlockReplacePacket"),
    PLAY_SOUND_2D(14, "finalforeach.cosmicreach.networking.netty.packets.sounds.PlaySound2DPacket"),
    PLAY_SOUND_3D(15, "finalforeach.cosmicreach.networking.netty.packets.sounds.PlaySound3DPacket"),
    CONTAINER_SYNC(17, "finalforeach.cosmicreach.networking.netty.packets.ContainerSyncPacket"),
    BLOCK_ENTITY_CONTAINER_SYNC(18, "finalforeach.cosmicreach.networking.netty.packets.blocks.BlockEntityContainerSyncPacket"),
    BLOCK_ENTITY_SCREEN(19, "finalforeach.cosmicreach.networking.netty.packets.blocks.BlockEntityScreenPacket"),
    BLOCK_ENTITY_DATA(20, "finalforeach.cosmicreach.networking.netty.packets.blocks.BlockEntityDataPacket");

    private static final ClientboundCosmicReachPackets[] REGISTRY = new ClientboundCosmicReachPackets[128];
    private static final Object2IntMap<String> CLASS_TO_ID = new Object2IntOpenHashMap<>();

    static {
        for (ClientboundCosmicReachPackets packet : values()) {
            REGISTRY[packet.id] = packet;
            CLASS_TO_ID.put(packet.className, packet.id);
        }
    }

    public static ClientboundCosmicReachPackets getPacket(final int id) {
        if (id < 0 || id >= REGISTRY.length) return null;

        return REGISTRY[id];
    }

    public static ClientboundCosmicReachPackets getPacket(final String className) {
        return CLASS_TO_ID.containsKey(className) ? REGISTRY[CLASS_TO_ID.getInt(className)] : null;
    }

    ClientboundCosmicReachPackets(final int id, final String className) {
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
