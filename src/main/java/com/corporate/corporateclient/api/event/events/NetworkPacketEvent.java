package com.corporate.corporateclient.api.event.events;

import com.corporate.corporateclient.api.event.Event;
import net.minecraft.network.Packet;

public class NetworkPacketEvent extends Event {

    public Packet m_Packet;


    public NetworkPacketEvent(Packet p_Packet) {
        super();
        m_Packet = p_Packet;
    }

    public Packet GetPacket() {
        return m_Packet;
    }

    public Packet getPacket() {
        return m_Packet;
    }
}