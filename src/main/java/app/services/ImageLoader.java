package app.services;

import app.model.ImageContent;

public interface ImageLoader {

    ImageContent load(String url);

}
