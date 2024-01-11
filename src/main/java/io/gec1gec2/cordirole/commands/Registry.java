package io.gec1gec2.cordirole.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class Registry {
    public void register(
            CommandDispatcher<ServerCommandSource> dispatcher,
            CommandRegistryAccess commandRegistryAccess,
            CommandManager.RegistrationEnvironment registrationEnvironment
    ) {
        RootCommandNode<ServerCommandSource> rootNode = dispatcher.getRoot();

        LiteralCommandNode<ServerCommandSource> crCommandNode;
        {
            LiteralCommandNode<ServerCommandSource> register = CommandManager.literal("register")
                    .executes(new RegisterCommand())
                    .build();

            crCommandNode = CommandManager.literal("cr")
                    .build();

            crCommandNode.addChild(register);
        }

        rootNode.addChild(crCommandNode);
    }
}
