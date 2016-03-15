/**
 * 
 */
package br.com.alura.designpatterns.cap6;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author eltonf
 *
 */
public class GoogleMaps implements Mapa {

	@Override
	public String devolveMapa(String rua) {
		String google = "https://maps.google.com.br/maps?q=vergeiros";
		URL url;
		try {
			url = new URL(google);
			InputStream openStream = url.openStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return google;
	}
}
