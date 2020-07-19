package com.codingchallenge;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@ManagedBean(name="wineBean")
@RequestScoped
public class WineBean implements Serializable{

	private static final long serialVersionUID = 3056209095192642300L;
	private List<String> selectedColumn = new ArrayList<>();
    private List<GrapeComponent> componentList = new ArrayList<>();
    private Map<String, String> columnMap = new LinkedHashMap<>();
    
    private String lotCode;
    private String description;
    private Double volume;
    private String tankCode;
    private String productState;
    private String ownerName;
    private JSONObject jsonObject;

	private String sortBy;
	InputStream inputStream;
	private String fileName;
	
//	 private static final Logger logger = LogManager.getLogger(WineTest.class);  
    public WineBean() {
    }
    
	@PostConstruct
	public void init() {
		FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		componentList.clear();
		columnMap.clear();
        initWineDetails();
		sortBy=  Singleton.getSortBy();
    	initColumns();
	}
	public void initWineDetails() {
		
//		Properties prop = new Properties();
//		String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
//		String propFile = "config.properties"; 
//		String path = null;
		
//		System.out.println(propFile);
		JSONParser parser = new JSONParser();
			try {
//				FileReader reader = new FileReader(propFile);
//				prop.load(reader);
//				System.out.println(prop);
//				fileName = prop.getProperty("fileName");
				fileName = "C:\\temp\\15MPPN002-VK.json";
				System.out.println(fileName);
				Object obj = parser.parse(new FileReader(fileName));
				jsonObject = (JSONObject) obj;
			
				
				lotCode = (String) jsonObject.get("lotCode");
				description = (String)jsonObject.get("description");
				tankCode = (String) jsonObject.get("tankCode");
				productState = (String) jsonObject.get("productState");
				ownerName = (String) jsonObject.get("ownerName");
				volume = (Double)jsonObject.get("volume");
				
				setLotCode(lotCode);
				setDescription(description);
				setVolume(volume);
				setTankCode(tankCode);
				setProductState(productState);
				setOwnerName(ownerName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	
		
	}
	
	@SuppressWarnings({ "rawtypes" })
	private void initGrapeComponentList() {
		
		JSONArray jsonArray = (JSONArray)jsonObject.get("components");
		
		Iterator iterator = jsonArray.iterator();
		while(iterator.hasNext()) {
		   JSONObject o = (JSONObject)iterator.next();
		   GrapeComponent gc = new GrapeComponent();
		   
		   gc.setVariety( (String) o.get("variety"));
		   gc.setPercentage((Double) o.get("percentage"));
		   gc.setRegion( (String) o.get("region"));
		   gc.setYear((int)(long) o.get("year"));
		   
		   
		   componentList.add(gc);
		}
	}
	
	
	public void selCol(String selCol) throws IOException {
    	Singleton.getINSTANCE();
		Singleton.setSortBy(selCol);

		//reload	
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());

		
	}
	
    public void initColumns() {

		addColumn("percentage", "Percentage (%)");
		
    	if(sortBy.equalsIgnoreCase("variety")) {
    		addColumn("variety", "Variety");
    	}if(sortBy.equalsIgnoreCase("region")) {
    		addColumn("region", "Region");
    	}if(sortBy.equalsIgnoreCase("year")) {
    		addColumn("year", "Year");
    	}if(sortBy.equalsIgnoreCase("varietyAndYear")) {
    		addColumn("variety", "Variety");
    		addColumn("year", "Year");
    	}

		selectedColumn.addAll(columnMap.keySet());
        initGrapeComponentList();
    }
   
    
	public List<GrapeComponent> getComponentList() {
		
		Collections.sort(componentList, new Comparator<GrapeComponent>() {
	        @Override public int compare(GrapeComponent bo1, GrapeComponent bo2) {
	            return (bo1.getPercentage() <  bo2.getPercentage() ? 1:-1); 
	        }
		});
	  return componentList;
	}
	

	public void loadTable() {

    	componentList.clear();
    	columnMap.clear();
	}

	
	private void addColumn(String propertyName, String displayName) {
        columnMap.put(propertyName, displayName);
    }
    public List<String> getselectedColumn() {
        return selectedColumn;
    }

    public void setselectedColumn(List<String> selectedColumn) {
        this.selectedColumn = selectedColumn;
    }

    public Map<String, String> getColumnMap() {
        return columnMap;
    }

	public String getLotCode() {
		return lotCode;
	}

	public void setLotCode(String lotCode) {
		this.lotCode = lotCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getTankCode() {
		return tankCode;
	}

	public void setTankCode(String tankCode) {
		this.tankCode = tankCode;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
    
    

}
