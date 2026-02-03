LV 0 – AWS 기본 인프라 구성
✔ Budget 설정
<img width="721" height="680" alt="스크린샷 2026-02-02 220650" src="https://github.com/user-attachments/assets/a9039a20-225e-4898-b20f-46b5b3949c30" />

월 $100 Budget 설정

사용량 알림

80% / 60% / 40% 도달 시 이메일 알림 설정

👉 비용 폭주 방지 및 운영 환경 관리 습관 학습

LV 1 – EC2 서버 생성 및 상태 확인
<img width="695" height="50" alt="스크린샷 2026-02-02 205304" src="https://github.com/user-attachments/assets/9f0b32a4-1be6-4e0f-9f00-a5ce357bdf4d" />

✔ EC2 생성

Amazon Linux

보안 그룹

SSH (22)

HTTP (80)

Custom TCP (8080)

✔ 서버 상태 확인

EC2 Status Check: UP

LV 2 - Spring Boot 배포 & 보안 설정
<img width="705" height="508" alt="스크린샷 2026-02-03 010431" src="https://github.com/user-attachments/assets/077f606a-761e-4529-8421-74ef1e7fa005" />
<img width="1436" height="245" alt="과제" src="https://github.com/user-attachments/assets/ab73b408-1037-44ca-ae30-a5cf9ba619da" />

application.properties        (공통)

application-local.properties  (로컬)

application-prod.properties   (운영)

LV 3 – 프로필 이미지 기능 & 권한 관리 (필수)
{
    "expiresAt": "2026-02-10T02:21:03.321452335Z",
    "url": "https://nbcam-spring-project.s3.ap-northeast-2.amazonaws.com/members/1/profile/350e5e25-329e-429d-a0bd-5bb5f180bb48.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjECoaDmFwLW5vcnRoZWFzdC0yIkgwRgIhAOeGGAidaV5vLabIlXEOulJxFcLN%2BgH7frERTzbtcwS7AiEAt7bW1kPz5qWKdkg9plUU8wmC%2FKlE2BSvtFl%2BcZ14Eqoq0gUI8%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARADGgw2NTI2NTE1Nzk0NTciDP7d1kCWq4t1Uo6%2BYyqmBZjrSwwJW3FO8PByCKC4TocBk4qxS6b67tkFOmx%2BodWIxmTiArBLl5mxn2lsk1v51tywH%2BaZjf3FMH3z4qxpgHMKBLoGn0IT8%2Fz0LiizkZ3aOgjDlJ4VKdLmLpVnYnegZVLgOMmjwz9UEo5lBqbf%2BtkSkIW4KzriyZgbD6GzdFyXw9XqO169fPA6S%2FptW3xBSK%2BpJ4viGfXRIFq0WKwYPlmpMlIqYtq561EH0IGYTB%2BmK4%2BwUG%2Bfcc8hO6leCODn787G6o5mUDj1c86S9vEkRI2FXJPH3l2HOssF6u9UT5s8rkcUB2HyXXK%2FCLKnEYU8GrSVQa78RHTiyAh1chEa2mPtv67%2B5VtFyatYcuJjdQftFaE7Y%2BY59VeSVkMOfc%2F6ByNpILqaRnRua91unRG2kjm7jKciF0mCEbBEBiw9AippeLJqdaUC9dzH0LYDno%2BC51%2BK9HyXddLI9l4EyXrgEPjy1KkzdyxSJDOItsBnMJPK%2FwGVzDVPisXV%2F8H0Y4xiqP%2Bs3u%2BgxrzAWowY24EuGTWpCs%2BVOyvlJkIekUdr2PHPM1tZhr2tmODPKk4rWLpydXzzyB9Je4Rr5hZsnZGGYcIiyokHnx3QvJu0I6g18uhoqI7R%2BxdpUeDhXy5gsaw6bYqxE9nb%2FcA8u4N2fVrlJ9mDxbcPChsuatJmJ38F6GacxogkKoFqcBjF2kSWJ52qp%2FZ2oowsJpXm0U6OKLbMXkJkbegGfLYvV92f8Ib376rXh87AKhxCWWGsBKMQWs3%2FAiwNBQj%2B2l4DjfULwftA%2F9Epw7Y%2F%2BGglNcEtvEUqbj5GmOMwtHKq4IvJuJKh0j2NHJlbGhCNZ91aA4wGsYFPkQXEtBi1VTqqqYnP3iZFYeJwreW%2Bd3hLxP%2Fj4B7Qft2AWiQ%2BqJzHBjD%2BqYXMBjqwAadHn4%2FMqCkW%2BhrxJWmyRIr1tGj%2Bqabv3RYsucuVfEWf7OhY6vx81ywrMgJrrNoIORMR5hjBO3U4ppHFJURUAYrTmDTUICzMvTH2i9BzPtpGanOPhtWZgenUUC%2FSeneFyIQuiABQ4%2BX77rCyjFX31724wl7k7nabFh%2BNHZLccBZHrq0rC0uQs5K9TypFXfMJErEY9T9xq%2FQn5f2gNxT4qNLINHT7GQIsI%2BvH1EXVHDSr&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20260203T022103Z&X-Amz-SignedHeaders=host&X-Amz-Credential=ASIAZP5IQZBA7RK6NE6D%2F20260203%2Fap-northeast-2%2Fs3%2Faws4_request&X-Amz-Expires=604800&X-Amz-Signature=5de5707d7cd20598a5cd69ea3f0b2018400f2ed1c672f23b4c701e0a6c0052b2"
}

💭 느낀 점

이번 과제는 단순히 기능을 구현하는 문제가 아니라,
실제 운영 환경에서 발생할 수 있는 문제를 그대로 경험하는 과정이었다.

특히 인상 깊었던 점은:

에러 메시지가 코드 문제가 아니라 의존성 충돌을 가리키고 있었고,

AWS SDK는 버전이 조금만 어긋나도 내부에서 NPE가 발생할 수 있다는 점이었다.

처음에는 계속 500 에러만 나서 많이 답답했지만,
로그를 끝까지 추적하면서
“아, 이건 내 코드 실수가 아니라 환경과 라이브러리 문제구나”라는 걸 깨닫게 됐다.

이번 경험을 통해:

로그를 두려워하지 않는 태도

단순 에러 해결이 아니라 왜 이런 문제가 발생했는지 구조적으로 이해하려는 시도
가 얼마나 중요한지 체감했다.

결과적으로 Presigned URL을 정상적으로 발급하고,
과제 요구사항(7일 유효기간, README 문서화)까지 모두 충족하면서
한 단계 더 실무에 가까워졌다는 느낌을 받았다.

✨ 한 줄 정리

AWS Presigned URL은 간단해 보이지만,
Region 설정과 SDK 버전 관리가 제대로 되어 있지 않으면 바로 지뢰가 된다.
로그를 끝까지 읽고 구조를 이해하는 것이 가장 빠른 해결책이었다.

