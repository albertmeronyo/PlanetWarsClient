PlanetWarsClient
================

PlanetWars Google AI contest Java client

**Copyright**: [Owners of the AI Challenge project] (http://code.google.com/p/ai-contest/)

**License**: [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0)

## What is this?

This is the source of the client Bots of the 2010 Google AI Challenge, [PlanetWars](http://planetwars.aichallenge.org/). For more information, please visit the official [site](http://planetwars.aichallenge.org/) and the source host at [Google Code](http://code.google.com/p/ai-contest/).

## Configuring Eclipse

After cloning, start Eclipse and create and configure a new project.

1. Go to File, New, Java Project.
2. In the New Java Project dialog, choose your preferred name for the project, untick 'Use default location' and type in/browse the directory where you clonned the repository.
3. Click Finish.

The source just needs to issue a simple javac command, so we change the builder configuration accordingly.

1. Right click on the project main folder, Properties.
2. Select Builders in the left list.
3. Untick 'Java Builder' in the builders list, click Ok to confirm disabling the default builder.
4. Click New.
5. In the 'Choose configuration type' dialog, select Program in the list and click OK.
6. In the 'Edit configuration' dialog, type a convenient name for the custom builder (e.g. 'javac'), and type the absolute path to your distribution binary for the java compiler (typically /usr/bin/javac). 
7. Set the working directory by clicking Browse Workspace and selecting the folder of the project from the list.
8. In the arguments box, type 'MyBot.java' (or your custom bot filename).
9. Click OK in the Edit Configuration dialog.
10. Click OK in the Properties dialog.

Now the project can be built by selecting Project, Build Project in the menu bar. The .class file for your bot will be generated.

## Hacking guide

Comming soon

## Requirements

* Java SDK >= 1.6
