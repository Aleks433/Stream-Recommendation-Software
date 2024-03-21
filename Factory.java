public class Factory {
    public static Factory factory;

    private Factory() {
    }

    public static Factory getFactory() {
        if(factory == null) {
            factory =  new Factory();
        }
        return factory;
    }

    public Command getCommand(String line) {
        if(line.contains("LISTEN")) {
            String[] aux = line.split(" ");
            return new CommandListenStream(Integer.parseInt(aux[0]), Integer.parseInt(aux[2]));
        }
        if(line.contains("LIST")) {
            String[] aux = line.split(" ");
            return new CommandListStreams(Integer.parseInt(aux[0]));
        }
        if(line.contains("ADD")) {
            String[] aux = line.split(" ");
            String name="";
            for(int i=6;i<aux.length;i++) {
                name += aux[i] + " ";
            }
            name = name.substring(0,name.length()-1);
            return new CommandAddStream(Integer.parseInt(aux[0]), Integer.parseInt(aux[2]), Integer.parseInt(aux[3]),
                    Integer.parseInt(aux[4]), Long.parseLong(aux[5]), name);
        }
        if(line.contains("DELETE")) {
            String[] aux = line.split(" ");
            return new CommandDeleteStream(Integer.parseInt(aux[0]), Integer.parseInt(aux[2]));
        }
        if(line.contains("RECOMMEND")) {
            String[] aux = line.split(" ");
            return new CommandRecommend(Integer.parseInt(aux[0]), aux[2]);
        }
        if(line.contains("SURPRISE")) {
            String[] aux = line.split(" ");
            return new CommandSurprise(Integer.parseInt(aux[0]), aux[2]);
        }
        return null;
    }

    public static void flush() {
        Factory.factory = null;
    }
}
