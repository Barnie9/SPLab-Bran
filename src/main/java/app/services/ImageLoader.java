package app.services;

import app.models.ImageContent;

public interface ImageLoader {

    ImageContent load(String url);

}
