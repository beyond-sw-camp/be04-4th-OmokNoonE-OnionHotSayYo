<template>
    <div id="myCarousel" class="carousel slide mb-6" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <!-- 각각의 아이템에 대한 인디케이터 버튼 -->
            <button v-for="(banner, index) in banners" 
                    :key="index" 
                    type="button" 
                    :data-bs-target="'#myCarousel'" 
                    :data-bs-slide-to="index" 
                    :class="index === 0 ? 'active' : ''" 
                    :aria-label="'Slide ' + (index + 1)"
                    :aria-current="index === 0 ? 'true' : ''"></button>
        </div>
        <div class="carousel-inner">
            <!-- 각각의 아이템에 대한 carousel 내용 -->
            <div v-for="(banner, index) in banners" 
                 :key="index" 
                 :class="'carousel-item' + (index === 0 ? ' active' : '')">
                <img :src="banner.IMAGE" width="100%" height="100%">
                <div class="container">
                    <div class="carousel-caption">
                        <h2 style="background-color: white; padding: 5px; color: black">{{ banner.TITLE }}</h2>
                    </div>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</template>

<script setup>
import { defineProps } from 'vue';

    const props = defineProps({
        banners: Array,
    })
    console.log(props);


</script>

<style scoped>
@import url(@/assets/carousel.css);

* {
  font-family: 'NanumBarunGothic' !important;

}
</style>
