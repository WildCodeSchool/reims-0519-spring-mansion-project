class Characters{
    private String name;
    private String dialogue;
    
    public String Watson(String name, String dialogue){
        this.name = name;
        this.dialogue = dialogue;

        // Insérer, si on est dans le Hall, Watson dit //

        return "Ecrire indice";
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDialogue() {
		return dialogue;
	}

	public void setDialogue(String dialogue) {
		this.dialogue = dialogue;
	}
    
}