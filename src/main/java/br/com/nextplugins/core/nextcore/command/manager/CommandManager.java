package br.com.nextplugins.core.nextcore.command.manager;

import br.com.nextplugins.core.nextcore.NextCore;
import br.com.nextplugins.core.nextcore.command.NextCommand;
import co.aikar.commands.PaperCommandManager;

public final class CommandManager {

    private final NextCore plugin;

    public CommandManager(NextCore plugin) {
        this.plugin = plugin;
    }

    public void init() {
        final PaperCommandManager commandManager = new PaperCommandManager(plugin);

        final NextCommand nextCommand = new NextCommand(plugin);

        commandManager.registerCommand(nextCommand);
    }

}
