class Character{
    private String name;
    private String dialog;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDialog() {
		return dialog;
	}

	public void setDialog(String dialog) {
		this.dialog = dialog;
	}

	public Characters(String name, String dialog) {
		this.name = name;
		this.dialog = dialog;
	}
    
}