package today.opai.example.modules;

import today.opai.api.enums.EnumModuleCategory;
import today.opai.api.enums.EnumUseEntityAction;
import today.opai.api.events.EventPacketSend;
import today.opai.api.interfaces.game.entity.LocalPlayer;
import today.opai.api.interfaces.game.network.NetPacket;
import today.opai.api.interfaces.game.network.client.CPacket02UseEntity;
import today.opai.example.EventScriptModule;
import today.opai.example.ExampleExtension;

public class SlowAutoBlock extends EventScriptModule {
    public SlowAutoBlock() {
        super("SlowAutoBlock","send attack packet and use right click",EnumModuleCategory.COMBAT);
    }

    @Override
    public void onPacketSend(EventPacketSend event) {
        LocalPlayer player = ExampleExtension.openAPI.getLocalPlayer();
        if (player.getInventory().getStackInSlot(player.getItemSlot()).getName().equalsIgnoreCase("sword")){
            NetPacket packet = event.getPacket();
            if (packet instanceof CPacket02UseEntity) {
                CPacket02UseEntity c02 = (CPacket02UseEntity) packet;
                if (c02.getAction() == EnumUseEntityAction.ATTACK) {
                    ExampleExtension.openAPI.getLocalPlayer().rightClickMouse();
                }
            }
        }
    }
}
