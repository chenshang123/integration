package team.sun.integration.protocol.tcp.channel;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelCatchMap {

    public static Map<String, ChannelHandlerContext> map = new ConcurrentHashMap<String, ChannelHandlerContext>();

    public static void add(String clientId, ChannelHandlerContext socketChannel) {
        boolean isContainsKey = ChannelCatchMap.map.containsKey(clientId);
        if(!isContainsKey){
            ChannelCatchMap.add(clientId, socketChannel);
        }
        map.put(clientId, socketChannel);
    }

    public static ChannelHandlerContext get(String clientId) {
        return map.get(clientId);
    }

    public static boolean sendHexData(String clientId, byte[] data) {
        ChannelHandlerContext ctx =  map.get(clientId);
        if (ctx != null) {
            if (ctx.isRemoved()) {
                map.remove(clientId);
                return false;
            } else {
                ctx.writeAndFlush(Unpooled.copiedBuffer(data));
                return true;
            }
        }
        return false;
    }

    public static String getId(ChannelHandlerContext socketChannel) {
        String id = null;
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == socketChannel) {
                id = "" + entry.getKey();
            }
        }
        return id;
    }

    public static void remove(ChannelHandlerContext socketChannel) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == socketChannel) {
                map.remove(entry.getKey());
            }
        }
    }

}
