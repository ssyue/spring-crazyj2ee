package ch08.se03.app;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.UrlResource;

public class UrlResourceTest {
	
	public static void main(String[] args) throws DocumentException, IOException {		
		// 创建一个Resource对象，从url读取资源
		UrlResource ur = new UrlResource("file:src/main/resources/book.xml");
		// 获取该资源的简单信息
		System.out.println(ur.getFilename());
		System.out.println(ur.getDescription());
		
		// 创建基于SAX的Dom4j解析器
		SAXReader reader = new SAXReader();
		Document doc = reader.read(ur.getFile());
		// 获取根元素
		Element el = doc.getRootElement();
		List l = el.elements();
		// 遍历根元素的全部子元素
		for(Iterator it = l.iterator(); it.hasNext(); ) {
			// 每个节点都是<书>节点
			Element book = (Element)it.next();
			List ll = book.elements();
			// 遍历<书>节点的全部子节点
			for(Iterator it2 = ll.iterator(); it2.hasNext(); ) {
				Element eee = (Element)it2.next();
				System.out.println(eee.getText());
			}
		}
	}
	
}
