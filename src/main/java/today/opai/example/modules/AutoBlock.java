package today.opai.example.modules;

import today.opai.api.enums.EnumModuleCategory;
import today.opai.api.enums.EnumUseEntityAction;
import today.opai.api.events.EventPacketSend;
import today.opai.api.interfaces.game.entity.LocalPlayer;
import today.opai.api.interfaces.game.network.NetPacket;
import today.opai.api.interfaces.game.network.client.CPacket02UseEntity;
import today.opai.api.interfaces.modules.values.BooleanValue;
import today.opai.example.EventScriptModule;
import today.opai.example.ExampleExtension;

public class AutoBlock extends EventScriptModule {

    public final BooleanValue onlySword = ExampleExtension.getAPI().getValueManager().createBoolean("Only Sword", true);

    public AutoBlock() {
        super("AutoBlock","send attack packet and use right click",EnumModuleCategory.COMBAT);
        super.setEventHandler(this);
        super.addValues(onlySword);
    }

    @Override
    public void onPacketSend(EventPacketSend event) {
        LocalPlayer player = ExampleExtension.openAPI.getLocalPlayer();

        NetPacket packet = event.getPacket();
        if (packet instanceof CPacket02UseEntity) {
            CPacket02UseEntity c02 = (CPacket02UseEntity) packet;
            if (c02.getAction() == EnumUseEntityAction.ATTACK) {
                if (onlySword.getValue()){
                    if (!player.getInventory().getMainInventory().get(player.getItemSlot()).getName().contains("sword")){
                        return;
                    }
                }
                ExampleExtension.openAPI.getLocalPlayer().rightClickMouse();
            }
        }
    }
}
