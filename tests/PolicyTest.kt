fun main() {
    val signalcase_1 = Signal(59, 98, 20, 15, 6)
    check(Policy.score(signalcase_1) == 64)
    check(Policy.classify(signalcase_1) == "review")
    val signalcase_2 = Signal(85, 104, 19, 11, 5)
    check(Policy.score(signalcase_2) == 147)
    check(Policy.classify(signalcase_2) == "review")
    val signalcase_3 = Signal(68, 99, 14, 16, 8)
    check(Policy.score(signalcase_3) == 107)
    check(Policy.classify(signalcase_3) == "review")
    val domainReview = DomainReview(63, 36, 8, 53)
    check(DomainReviewLens.score(domainReview) == 191)
    check(DomainReviewLens.lane(domainReview) == "ship")
}
