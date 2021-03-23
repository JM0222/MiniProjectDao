package pb_book;

public class PbookVo {
	// field
	private long id;
    private String name;
    private String hp;
    private String tel;
    
    // constructor
    public PbookVo() {
    	
    }
    
    public PbookVo(String name, String hp, String tel) {
    	this.name = name;
    	this.hp = hp;
    	this.tel = tel;
    }
    
    public PbookVo(Long id, String name, String hp, String tel) {
    	this(name,hp,tel);
    	this.id = id;
    }
    
    // Getter / Setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	// °´Ã¼ Ãâ·Â

	@Override
	public String toString() {
		return id +" "+ name +" "+  hp +" "+ tel ;
	}
	
    
}
