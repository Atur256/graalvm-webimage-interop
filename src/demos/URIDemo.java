package demos;

import builtin.URI;


public class URIDemo {

    public static void main(String[] args) {

        System.out.println("encodeURI/decodeURI:");

        String uri = "https://mozilla.org/?x=шеллы";

        System.out.println("Uri: " + uri);

        String  encoded = URI.encodeURI(uri);

        System.out.println("Encoded uri: " + encoded);

        String decodedUri = URI.decodeURI(encoded);

        System.out.println("Decoded uri: " + decodedUri);

        System.out.println("encodeURIComponent/decodeURIComponent:");

        String uriComponent = "/test?";

        System.out.println("Uri component: " + uriComponent);

        String encodedUriComponent = URI.encodeURIComponent(uriComponent);

        System.out.println("Decoded uri component: " + encodedUriComponent);

        String  decodedUriComponent = URI.decodeURIComponent(encodedUriComponent);

        System.out.println("Encoded uri component: " + decodedUriComponent);
    }
}
