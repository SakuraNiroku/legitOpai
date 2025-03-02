package today.opai.example;

import today.opai.api.Extension;
import today.opai.api.OpenAPI;
import today.opai.api.annotations.ExtensionInfo;
import today.opai.api.features.ExtensionModule;
import today.opai.example.commands.BindsCommand;
import today.opai.example.modules.SlowAutoBlock;

// Required @ExtensionInfo annotation
@ExtensionInfo(name = "Example Extension",author = "cubk",version = "1.0")
public class ExampleExtension extends Extension {
    public static OpenAPI openAPI;

    @Override
    public void initialize(OpenAPI openAPI) {
        ExampleExtension.openAPI = openAPI;
        // Command
        openAPI.registerFeature(new BindsCommand());

        // Modules
        registerEvent(new SlowAutoBlock());

    }

    private void registerEvent(EventScriptModule module){
        module.setEventHandler(module);
        openAPI.registerFeature(module);
    }
}
