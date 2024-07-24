package p439OverlappingInterFace;

public class Button {
	OnClickListener listener;
	
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}

	void touch() {
		listener.onClick();
	}

	static interface OnClickListener{
		void onClick();
	}
	
}
