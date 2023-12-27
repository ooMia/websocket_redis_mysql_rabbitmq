package com.sinor.backend.websocket.service;

import com.sinor.backend.websocket.common.AbstractCrudService;
import com.sinor.backend.websocket.model.dto.request.VoteLogRequestDto;
import com.sinor.backend.websocket.model.dto.response.VoteLogResponseDto;
import com.sinor.backend.websocket.model.entity.board.vote.VoteLog;
import com.sinor.backend.websocket.repository.VoteLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteLogService extends
        AbstractCrudService<VoteLogResponseDto, VoteLogRequestDto, VoteLogRepository, VoteLog, Long> {

    private final MemberService memberService;

    @Autowired
    public VoteLogService(VoteLogRepository voteLogRepository, MemberService memberService) {
        super(voteLogRepository);
        this.memberService = memberService;
    }

    @Override
    protected VoteLog fromRequestDtoToEntity(VoteLogRequestDto voteLogRequestDto) {
        return VoteLog.builder()
                .voteCandidateId(voteLogRequestDto.voteCandidateId())
                .memberId(voteLogRequestDto.memberId())
                .build();
    }

    @Override
    protected VoteLogResponseDto fromEntitytoResponseDto(VoteLog voteLog) {
        return VoteLogResponseDto.builder()
                .id(voteLog.getId())
                .memberId(voteLog.getMemberId())
                .voteCandidateId(voteLog.getVoteCandidateId())
                .build();
    }

    @Override
    public VoteLogResponseDto updateObject(Long id, VoteLogRequestDto voteLogRequestDto) {
        return null;
    }
}