package org.omoknoone.onionhotsayyo.hotpost.vo;

import lombok.Getter;
import lombok.ToString;
import org.omoknoone.onionhotsayyo.hotpost.dto.HotPostListByCategoryDTO;

import java.util.List;


@Getter
@ToString
public class ResponseHotPostListByCategory {

    private final List<HotPostListByCategoryDTO> hotCategoryPosts;

    public ResponseHotPostListByCategory(List<HotPostListByCategoryDTO> hotCategoryPosts) {
        this.hotCategoryPosts = hotCategoryPosts;
    }
}
