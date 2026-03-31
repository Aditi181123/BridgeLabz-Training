package annotations;

class LegacyAPI{
	@Deprecated
	public void oldFeature() {
		System.out.println("Old Feature");
	}
	
	public void newFeature() {
		System.out.println("New Feature");
	}
}

public class DeprecatedExample {
	public static void main(String[] args) {
		LegacyAPI api = new LegacyAPI() ;
		api.oldFeature();
		api.newFeature();
	}
}
