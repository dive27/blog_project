package model.dto;

public class EmotionDto {
	int emo_no ;
    String emotion ; 
    String emo_img ;
    
    public EmotionDto() {}

	public EmotionDto(int emo_no, String emotion, String emo_img) {
		super();
		this.emo_no = emo_no;
		this.emotion = emotion;
		this.emo_img = emo_img;
	}

	public int getEmo_no() {
		return emo_no;
	}

	public void setEmo_no(int emo_no) {
		this.emo_no = emo_no;
	}

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public String getEmo_img() {
		return emo_img;
	}

	public void setEmo_img(String emo_img) {
		this.emo_img = emo_img;
	}

	@Override
	public String toString() {
		return "EmotionDto [emo_no=" + emo_no + ", emotion=" + emotion + ", emo_img=" + emo_img + "]";
	}
    
    
}
