package today.opai.example;

import today.opai.api.Extension;
import today.opai.api.OpenAPI;
import today.opai.api.annotations.ExtensionInfo;
import today.opai.example.commands.BindsCommand;
import today.opai.example.commands.IRCCountCommand;
import today.opai.example.modules.AutoBlock;

// Required @ExtensionInfo annotation
@ExtensionInfo(name = "LegitOpai",author = "Hikari",version = "1.0")
public class ExampleExtension extends Extension {
    public static OpenAPI openAPI;

    @Override
    public void initialize(OpenAPI openAPI) {
        ExampleExtension.openAPI = openAPI;
        // Command
        openAPI.registerFeature(new BindsCommand());
        openAPI.registerFeature(new IRCCountCommand());

        // Modules
        openAPI.registerFeature(new AutoBlock());

    }
}
