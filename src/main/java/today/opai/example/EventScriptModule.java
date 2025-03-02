package today.opai.example;

import today.opai.api.enums.EnumModuleCategory;
import today.opai.api.features.ExtensionModule;
import today.opai.api.interfaces.EventHandler;

public class EventScriptModule extends ExtensionModule implements EventHandler {
    public EventScriptModule(String name, String description, EnumModuleCategory category) {
        super(name, description, category);
    }
}
