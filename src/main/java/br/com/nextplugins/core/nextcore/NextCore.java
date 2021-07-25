package br.com.nextplugins.core.nextcore;

import br.com.nextplugins.core.nextcore.command.manager.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class NextCore extends JavaPlugin {

    private final CommandManager commandManager = new CommandManager(this);

    @Override
    public void onEnable() {
        try {
            commandManager.init();

            getLogger().info("Plugin inicializado com sucesso!");
        } catch (Throwable t) {
            t.printStackTrace();
            getLogger().severe("Não foi possível ligar o plugin.");
        }
    }

}
